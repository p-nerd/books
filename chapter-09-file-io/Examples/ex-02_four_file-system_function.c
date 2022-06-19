#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    char str[80] = "This is a file system test.\n";
    FILE *fp;
    char *p;
    int i;

    // open myfile for output
    fp = fopen("myfile", "w");
    if (fp == NULL) {
        printf("Cannot open file.\n");
        exit(1);
    }

    // write str to disk
    p = str;
    while (*p) {
        if (fputc(*p, fp) == EOF) {
            printf("Error writing file.\n");
            exit(1);
        }
        p++;
    }
    fclose(fp);

    // open myfile for input
    fp = fopen("myfile", "r");
    if (fp == NULL) {
        printf("Cannot open file.\n");
        exit(1);
    }

    // read back the file
    for (;;) {
        i = fgetc(fp);
        if (i == EOF) break;
        putchar(i);
    }
    fclose(fp);
    
    return 0;
}
// Date: শুক্রবার, মার্চ 05, 2021 | 14:31:04
