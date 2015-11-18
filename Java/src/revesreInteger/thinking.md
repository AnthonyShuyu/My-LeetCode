# Math IntegerOverflow

Reverse Integer

Consider Integer is 32 bit, range 2^32-1 ~ -2^32, when reversing, it may overflow, so need to check if it is
overflow

methods

- int newResult = result*10 + x%10;
- if (newResult/10 != result) result = 0;
