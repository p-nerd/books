#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    FILE *fp1, *fp2;
    char ch1, ch2, same;
    unsigned long l;

    // see if correct number fo command line arguments
    if (argc != 3) {
        printf("Usage: compate <file 1> <file 2>\n");
        exit(1);
    }

    // open first file
    if ((fp1 = fopen(argv[1], "rb")) == NULL) {
        printf("Cannot open first file.\n");
        exit(1);
    }
    if ((fp2 = fopen(argv[2], "rb")) == NULL) {
        printf("Cannot open second file.\n");
        exit(1);
    }

    l = 0;
    same = 1;
    // compare thr files
    while (!feof(fp1)) {
        ch1 = fgetc(fp1);
        if (ferror(fp1)) {
            printf("Error reading first file.\n");
            exit(1);
        }
        ch2 = fgetc(fp2);
        if (ferror(fp2)) {
            printf("Error rading second file.\n");
            exit(1);
        }
        if (ch1 != ch2) {
            printf("Files differ at byte number %lu\n", l);
            same = 0;
            break;
        }
        l++;
    }
    if (same)
        printf("File are athe same.\n");

    if (fclose(fp1) == EOF) {
        printf("Error closing first file.\n");
        exit(1);
    }
    if (fclose(fp2) == EOF) {
        printf("Error closing second file.\n");
    }

    return 0;
}