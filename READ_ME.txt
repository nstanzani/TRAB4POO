Arnaldo Lopes Stanzani - 8937510
Guilherme Gonçalves - 8937055
Guilherme Silva dos Anjos - 8936839

Trabalho desenvolvido na IDE IntelliJ IDEA 14.1.3

Instruções de utilização:

    Para executar o programa é necessário ter ambos os arquivos .jar, encontrados na pasta /out/artifacts/, e os
    arquivos products.csv e users.csv, na mesma pasta.

    Então executar o arquivo Server.jar, passando como argumentos a porta em que o server será aberto:

        java -jar Server.jar [port]

    E então será possível conectar vários clientes nesse server aberto, utilizando o arquivo Client.jar, passando
    o ip e a porta como argumentos:

        java -jar Client.jar [ip] [port]

    O código fonte está contido em /src/br/usp/icmc/ssc0103
    Os .class estão em /out/production/br/usp/icmc/ssc0103