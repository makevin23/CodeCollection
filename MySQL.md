# MySQL Code Collection

## LEAD and LAG

The `LEAD()` function returns the value of `expression` from the `offset-th` row of the ordered partition.

LEAD() function *look up*

```
LEAD(<expression>[,offset[, default_value]]) OVER (
    PARTITION BY (expr)
    ORDER BY (expr)
)
```

LAG() function *look down*

```
LAG(<expression>[,offset[, default_value]]) OVER (
    PARTITION BY (expr)
    ORDER BY (expr)
)
```

## RANK

`RANK()` skips a rank if there is a duplicated number. 
e.g.
```
200 | 1
200 | 1
199 | 2
```

```
RANK() OVER (PARTITION BY (expr) ORDER BY (expr)) DESC/ASC)
```

`DENSE_RANK()` never skips a rank.
e.g.
```
200 | 1
200 | 1
199 | 2
```

```
DENSE_RANK() OVER (PARTITION BY (expr) ORDER BY (expr)) DESC/ASC)
```


## cte

Introduction [https://www.mysqltutorial.org/mysql-cte/]


## Date

cast a string to date

```
CAST('2014-02-01' AS DATE)
```

select between a date interval

```
WHERE order_date BETWEEN CAST('2014-02-01' AS DATE) AND CAST('2014-02-28' AS DATE)
```

select after a date (inclusive)

```
WHERE order_date >= CAST('2014-02-01' AS DATE)
```

select before a date (exclusive)

```
WHERE order_date <= CAST('2014-02-28' AS DATE)
```

## remain number of digits after the decimal point

```
convert(num, decimal(p, d))
```

- P is the precision that represents __the number of significant digits__. The range of P is 1 to 65.
- D is the scale that that represents __the number of digits after the decimal point__. The range of D is 0 and 30. MySQL requires that __D is less than or equal to (<=) P__.

```
convert(0.3333333, decimal(4,2))
=> 0.33
```

*OR*

use `round(num, digits)`

```
ROUND(345.156, 1);
=> 345.1
ROUND(345.156, 2);
=> 345.15
```

## count under condition

combine `sum` and `if`

```
sum(if(Status="cancelled_by_driver" or Status="cancelled_by_client",1,0))
```

```
if(condition, value_if_true, value_if_false)
```

