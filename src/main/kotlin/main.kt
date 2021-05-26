fun main() {
    println("Bem vindo ao Bytebank!");
    //variaveis()
    //fluxoDeRepeticao()
    //entendendoDiferencaEntreCopiaEReferencia()

    val contaRodrigo = Conta()
    contaRodrigo.titular = "Rodrigo"
    contaRodrigo.numero = 1000
    contaRodrigo.saldo = 200.0

    val contaFran = Conta()
    contaFran.titular = "Fran"
    contaFran.numero = 1001
    contaFran.saldo = 300.0

    println(contaRodrigo.titular)
    println(contaRodrigo.numero)
    println(contaRodrigo.saldo)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("Depositando na conta do ${contaRodrigo.titular}")
    deposita(contaRodrigo, 50.0)
    println("Saldo da conta Rodrigo é de: ${contaRodrigo.saldo}")

}

//Criando a classe Conta - Vamos melhorar no futuro
class Conta{
    var titular = ""
    var numero = 0
    var saldo = 0.0

}

fun deposita(conta: Conta, valor: Double){
    conta.saldo += valor
}



fun variaveis() {
    println("Bem vindo ao Bytebank!");

    //val é a variaável que não pode mudar de valor e é uma boa prática usá-la!
    //No kotlin não precisamos tipar as variaveis,
    // mas o valor dado a variavel vai tipificar ela! Como deu dei texto, o seu tipo será String.
    //Caso eu queria tipar explicitamente a variavel, ficaria -> val titular: String = "Rodrigo"
    val titular = "Rodrigo"
    val numeroConta = 1000

    // o trecho titular = "Rodrigo Franco" vai dar erro, pois usamos val, para mudar usamos o var:
    var titularMutavel = "Rodrigo"
    titularMutavel = "Rodrigo Franco"
    var saldo = 0.0
    saldo += 100.00

    //Exemplos com concatenação
    //println("Titular " + titular)

    //Exemplos do Template - O mais utilizado!
    println("Titular $titular")
    println("Número da Conta $numeroConta")
    println("Saldo $saldo")
}

fun fluxoDeRepeticao() {
    var saldo = 0.0

    //Quando fazemos esse IF a IDE sugere utilizarmos o When, ilustrado a seguir:
    if (saldo > 0.0) {
        println("Saldo é positivo")
    } else if (saldo == 0.0) {
        println("Saldo é neutro")
    } else {
        println("Saldo é negativo")
    }

    //Fazendo a mesma coisa que o if anterior
    when {
        saldo > 0.0 -> {
            println("Saldo é positivo")
        }
        saldo == 0.0 -> {
            println("Saldo é neutro")
        }
        else -> {
            println("Saldo é negativo")
        }
    }
    //Quando a condicional faz apenas uma coisa, no nosso caso apenas um print, podemos deixar o when assim
    when {
        saldo > 0.0 -> println("Saldo é positivo")
        saldo == 0.0 -> println("Saldo é neutro")
        else -> println("Saldo é negativo")
    }

    //Loopings:

    //O for abaixo, para percorrer uma collection, mas nao aprendemos collection ainda
    //for(item in collection) println(item)

    //O for abaixo, para percorrer uma collection, mas nao aprendemos collection ainda
    //for(item: int in ints) {

    // }

    //Passando por todos elementos de 1 a 5
    for (i in 1..5) {
        println(i)
    }

    //Passando por todos elementos de 1 a 5, mas pulando de 2 em 2
    //Começa passando pelo 1, depois vai para o 3 e 5, pois (1+2=3) e (3+2=5)
    for (i in 1..5 step 2) {
        println(i)
    }

    //Passando por todos elementos de 5 a 1, ou seja, ordem inversa
    for (i in 5 downTo 1) {
        println(i)
    }

    //Temos uma laço de repetição. O laço se repete enquanto  a condicional for verdadeira
    //Ñ podemos de esquecer de iniciar a variavel e de incrementá-la dentro do código
    var i = 0
    while (i < 5) {
        println(i)
        i++
    }

    //Outra forma de usar o while
    var t=0
    do{
        println("Do while $t")
        t++
    }while(t<5)
}

fun entendendoDiferencaEntreCopiaEReferencia(){
    //É igual no java
    //contaRodrigo é uma referencia para o objeto do tipo Conta
    val contaRodrigo = Conta()
    contaRodrigo.titular = "Rodrigo"
    contaRodrigo.numero = 1000
    contaRodrigo.saldo = 200.0

    val contaFran = Conta()
    contaFran.titular = "Fran"
    contaFran.numero = 1001
    contaFran.saldo = 300.0

    println(contaRodrigo.titular)
    println(contaRodrigo.numero)
    println(contaRodrigo.saldo)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    // Inicio do: Entendo copia e referencia:

    // --Variaveis com tipo Primitivo:
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    //Apenas o numeroY foi alterado! Pois com número primitivo ocorre a Copia!
    println("numeroX $numeroX")
    println("numeroY $numeroY")

    // --Variaveis que são referencia de um objeto
    val contaJoao = Conta()
    contaJoao.titular = "João"

    val contaMaria = contaJoao;
    contaMaria.titular = "Maria"

    //Ambas as contas foram alteradas! Pois a variável que aponta para objeto é sempre uma referencia!
    //Apontam para o mesmo endereço de memoria!
    println("Titular de contaJoao é ${contaJoao.titular}")
    println("Titular de contaMaria é ${contaMaria.titular}")

    //Fim do: Entendendo copia e referencia.
}