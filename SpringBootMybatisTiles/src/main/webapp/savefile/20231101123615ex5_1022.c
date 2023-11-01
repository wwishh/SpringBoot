#include <stdio.h>
#include <conio.h>

void ex_07(void)
{
    char stra[50], strb[50];
    int i, j;

    printf("문자열입력 : ");
    gets(stra);
    printf("문자열입력 : ");
    gets(strb);

    for (i = 0; stra[i]; i++)
        ;
    for (j = 0; strb[j]; j++)
        ;

    if (i == j)
    {
        i = 0;
        j = 0;
        while (stra[i])
        {
            if (stra[i] == strb[j])
            {
                i++;
                j++;
            }
            else
            {
                printf("%s, %s, 다름.", stra, strb);
                break;
            }
        }
        if (stra[i] == strb[j])
        {
            printf("%s, %s, 같음.", stra, strb);
        }
    }
    else
    {
        printf("%s, %s, 다름.", stra, strb);
    }
}

int main(){
    ex_07();

    return 0;
}