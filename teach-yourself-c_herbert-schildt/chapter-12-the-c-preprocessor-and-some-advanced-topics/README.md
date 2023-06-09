# chapter12 the c preprocessor and some advanced topics

- objective
  - The C preprocessor
  - pointers to functions
  - dynamic allocation system

## 12.1 - learn more about #define #include

- Function like macros

## 12.2 - understand conditional compilation

- #if
- #else
- #elif
- #endif
- #ifdef
- #ifndef

## 12.3 - learn about #error #undef #line

- #error
- #undef
- #line
- #pragma

## 12.4 - examine c s built in macros

- `__FILE__`
- `__LINE__`
- `__DATE__`
- `__TIME__`
- `__STDC__`

## 12.5 - use the #and ##operators

- The # operator turns the argument of a function-like macro into a quoted string.

## 12.6-understand-function-pointers

- Function-pointer array are typically used when writing systems software, such as compilers, assemblers and interpreters.
- qsort() prototype: `void qsort(void *array, size_t number, size_t size, int(*comp)(const void *a, cont void *b)`
- `size_t` is defined by the C compiler and is loosely the same as unsigned

## 12.7-master-dynamic-allocation

- Dynamic allocation is the process by which memory is allocated as needed during runtime.
- `void *malloc(size_t numbytes);`
- `void free(void *ptr)`
- Memory is allocated from a region called the heap.
- when a program terminates, all allocated memory is automatically released.
