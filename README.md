
# KrenakLogo

O projeto KrenakLogo é uma iniciativa desenvolvida no **Instituto Federal Fluminense**, como parte do curso de **Bacharelado em Engenharia de Computação** na disciplina de **Compiladores** da turma do **6° Período** do 2° semestre de 2024. 

Este projeto visa criar um compilador para a língua indígena Krenak, utilizando a linguagem Logo como referência. A língua Krenak, pertencente à família Macro-Jê e falada pela comunidade Krenak no Vale do Rio Doce, em Minas Gerais, enfrenta o risco de extinção devido à pressão cultural dominante e eventos ambientais adversos, como o desastre da barragem da Samarco em 2015. 

O KrenakLogo busca preservar e valorizar esta rica cultura, adaptando conceitos da linguagem Logo para criar uma plataforma de programação acessível e educativa que represente a cultura Krenak. Este projeto proporciona uma oportunidade única para a comunidade acadêmica e a sociedade se envolverem com a cultura indígena de maneira inovadora e tecnológica, promovendo a preservação linguística e cultural.

## Passo a Passo para Utilizar o KrenakLogo

1. **Instale o Java JDK 19**
   - Certifique-se de ter o **Java JDK 19** instalado no seu computador. Se ainda não tiver, você pode baixá-lo do [site oficial da Oracle](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html).

2. **Instale o UCBLogo (Berkeley Logo)**
   - O KrenakLogo foi inspirado pela linguagem Logo, e você precisará instalar o **UCBLogo**. 
   - Baixe o UCBLogo do [site oficial da Berkeley](https://people.eecs.berkeley.edu/~bh/logo.html).
   - Instale no diretório padrão `"D:\\Program Files (x86)\\UCBLogo\\ucblogo.exe"`.

3. **Baixe o Código do Projeto**
   - Baixe o código do projeto desse Github.
   - Você pode baixar o repositório como um arquivo `.zip` ou cloná-lo usando o Git.

4. **Abra o Projeto no Apache NetBeans**
   - Instale o **Apache NetBeans** se ainda não tiver. Você pode baixá-lo [aqui](https://netbeans.apache.org/front/main/download/nb22/).
   - Lembre-se de configurar para o **Java JDK 19**!
   - Abra o NetBeans e use `File > Open Project` para abrir o projeto KrenakLogo que você baixou do GitHub.

5. **Compile e Execute o Projeto**
   - No NetBeans, clique com o botão direito no projeto e selecione `Clean and Build`. Isso irá compilar o projeto e resolver quaisquer dependências.
   - Depois, clique em `Run` para executar o projeto.

6. **Programar na Interface IDE**
   - Após o projeto ser executado, a interface da IDE do KrenakLogo será aberta.
   - A partir daí, você pode começar a programar utilizando a sintaxe do KrenakLogo, criando funções, desenhando formas, e explorando os comandos que foram definidos.


## Guia de Uso
#### Declaração de Funções

A construção de funções em KrenakLogo segue o modelo tradicional da linguagem Logo, adaptado para a sintaxe Krenak. A palavra-chave `tupü` é utilizada para declarar uma nova função, enquanto `ak` marca o fim da função. A estrutura básica é:

```krenaklogo
tupü NomeDaFuncao
    ;Comandos e operações
ak
```

Exemplo:

```krenaklogo
tupü main
	intai 4 [ mg 100 nk 90 ]
ak

main
```

#### Comandos de Movimento

Os comandos de movimento são centrais em KrenakLogo, permitindo a manipulação da "tartaruga" virtual. Alguns dos principais comandos incluem:

-   `mg` (`fd` em Logo): Move a tartaruga para frente.
-   `at` (`bk` em Logo): Move a tartaruga para trás.
-   `nk` (`rt` em Logo): Gira a tartaruga para a direita.
-   `mk` (`lt` em Logo): Gira a tartaruga para a esquerda.

Exemplo:

```krenaklogo
mg 100
nk 90
mg 50
```

#### Estruturas de Controle

KrenakLogo também suporta estruturas de controle, como loops e condicionais. A estrutura `intai` (`repeat` em Logo) permite repetir um bloco de comandos, enquanto `huk` (`if` em Logo) avalia uma condição.

Exemplo de loop:

```krenaklogo
intai 5 [ mg 50 nk 72 ]
```

Exemplo de condicional:
```krenaklogo
huk (:condicao = 0) [ mrong 100 nikuanin 90 mrong 100 ]
huk (:condicao = 1) [ anthore 100 mk 90 anthore 100 ]
```

#### Comandos de Desenho

Além de mover a tartaruga, KrenakLogo oferece comandos para controlar a escrita e o desenho, como:

-   `ph` (`pd` em Logo): Baixa a caneta para desenhar.
-   `pb` (`pu` em Logo): Levanta a caneta para mover sem desenhar.
-   `kr` (`cs` em Logo): Limpa a tela.

Exemplo:

```krenaklogo
tupü DesenharTriangulo
    ph
    intai 3 [ mg 100 nk 120 ]
    pb
ak
```

#### Comentários

Para adicionar comentários e notas explicativas no código, utilize `;` no início da linha. Comentários são ignorados pelo compilador e servem para ajudar na compreensão do código.

Exemplo:

```krenaklogo
;Esta função desenha um quadrado
tupü quadrado
	intai 4 [ mg 100 nk 90 ]
ak
```

#### Estrutura Completa

A seguir, um exemplo de programa KrenakLogo completo que combina os elementos discutidos:

```krenaklogo
; Programa para desenhar uma estrela
tupü ngora :kiiuk
   huk :kiiuk < 5 [mrong  :kiiuk anthore :kiiuk jan]
   mrong :kiiuk/3
   mokia 30 ngora :kiiuk*2/3 nikuanin 30
   mrong :kiiuk/6
   nikuanin 25 ngora :kiiuk/2 mokia 25
   mrong :kiiuk/3
   nikuanin 25 ngora :kiiuk/2 mokia 25
   mrong :kiiuk/6
   anthore:kiiuk
ak
kurim
ngora 150
```

## Dicionário (Tabela de Traduções)

| LOGO            | KRENAK               | TRADUÇÃO                    |
|-----------------|----------------------|-----------------------------|
| to              | tupü                 | Fazer                       |
| end             | ak                   | Fim                         |
| repeat          | intai                | Repetir                     |
| if              | Huk                  | Qual                        |
| make            | intschom             | Fazer                       |
| print           | pip                  | Ver                         |
| fd/forward      | mg / mrong           | Para frente                 |
| bk/backward     | at / anthore         | Para trás                   |
| rt/right        | nk / nikuanin        | Para direita                |
| lt/left         | mk / mokia           | Para esquerda               |
| cs/clearscreen  | kr / kurim           | Limpar                      |
| pu/penup        | pb / po tu um bakui  | Punho acima                 |
| pd/pendown      | ph / po tu um hek hek| Punho baixo                 |
| ht/hideturtle   | hh / Hion-Hinkut     | Esconder tartaruga          |
| st/showturtle   | kh / Kan-Hinkut      | Mostrar-me tartaruga        |
| home            | kischem              | Casa                        |
| stop            | jan                  | Sair                        |
| label           | KanHun               | Nome                        |
| setxy           | iopu                 | Pó-iopu/ Dedo indicador     |
| for             | himpa                | Muitas vezes                |
| random          | krahi imakuan        | Alguém                      |
