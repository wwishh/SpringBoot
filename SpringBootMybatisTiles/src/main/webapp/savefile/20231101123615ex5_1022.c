#include <stdio.h>
#include <conio.h>

void ex_07(void)
{
    char stra[50], strb[50];
    int i, j;

    printf("���ڿ��Է� : ");
    gets(stra);
    printf("���ڿ��Է� : ");
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
                printf("%s, %s, �ٸ�.", stra, strb);
                break;
            }
        }
        if (stra[i] == strb[j])
        {
            printf("%s, %s, ����.", stra, strb);
        }
    }
    else
    {
        printf("%s, %s, �ٸ�.", stra, strb);
    }
}

int main(){
    ex_07();

    return 0;
}