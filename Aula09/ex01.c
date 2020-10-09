#include <stdio.h>
#include <stdbool.h>

int main()
{
    /**
     * count[0] = candidato 1
     * count[1] = candidato 2
     * count[2] = candidato 3
     * count[3] = candidato 4
     * count[4] = voto em branco
     */
    int count[5] = {0,0,0,0,0}, option;
    bool check = true;

    do {
        do {
            printf("Vote em um candidato"
                "\n => 1"
                "\n => 2"
                "\n => 3"
                "\n => 4"
                "\n => branco - 5"
                "\n => Voto: "
            );
            scanf("%d", &option);

            check = true;

            switch (option) {
                case 1:
                    count[0]++;
                    break;
                case 2:
                    count[1]++;
                    break;
                case 3:
                    count[2]++;
                    break;
                case 4:
                    count[3]++;
                    break;
                case 5:
                    count[4]++;
                    break;
                default:
                    if(option != 0) {
                        printf("\n<==============================>\n"
                            "\n  Voto informado esta invalido\n"
                            "\n<==============================>\n"
                        );
                        check = false;
                    }
            }
        }while (check == false);
    }while(option != 0);

    printf("Contagem de votos"
    "\n => 1 - %d\n => 2 - %d\n => 3 - %d\n => 4 - %d\n => branco - %d",
    count[0] ,count[1] ,count[2] ,count[3] ,count[4]);
}
