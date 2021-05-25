fun main(){
    println("Bem vindo ao Bytebank!");

    //val é a variaável que não pode mudar de valor e é uma boa prática usá-la!
    //No kotlin não precisamos tipar as variaveis,
    // mas o valor dado a variavel vai tipificar ela! Como deu dei texto, o seu tipo será String.
    //Caso eu queria tipar explicitamente a variavel, ficaria -> val titular: String = "Rodrigo"
    val titular  = "Rodrigo"
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