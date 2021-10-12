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