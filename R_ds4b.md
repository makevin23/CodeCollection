# useful R code from Data Science for Business WS21/22

## Week 2

### import library

```R
library(ISLR)
library(tidyverse)
library(ggthemr) # see https://github.com/Mikata-Project/ggthemr for installation instructions
library(descr)
library(kknn)
library(caret)
```

### Set up workspace

remove all existing data from working memory

```R
rm(list=ls())
```

initialize the random number generator

```R
set.seed(42)
```

turn off scientific notation of large numbers

```R
options(scipen=10000)
```

set a standard theme for plotting

```R
ggthemr('flat')
```

### import data

import `Default` dataset from ISLR package

```R
data(Default)
```

show dimensions

```R
dim(Default)
```

show variable names

```R
names(Default)
```

display the first couple of lines

```R
head(Default)
```

remove the `student` variable from data frame

```R
Default <- Default %>% 
  select(-student)
```

### explore data

Calculate summary statistics

```R
summary(Default)
```

Create a cross-table of the `default` variable.

```R
CrossTable(Default$default)
```

### Visualizations

Plot a histogram of the `balance` variable.

```R
ggplot(data=Default) + 
    geom_histrogram(mapping=aes(x=balance))
```

Plot a histogram of the `income` variable

```R
ggplot(data=Default)+
  geom_histogram(aes(income))
```

Create a box plot of `balance`, grouped by `default`.

```R
ggplot(data = Default) +
  geom_boxplot(mapping = aes(x = default, y = balance))
```

Create a box plot of `income`, grouped by `default`.

```R
ggplot(Default)+
  geom_boxplot(aes(default, income))
```

Create a scatter plot of `balance` and `income`, colored by `default`.

```R
ggplot(data = Default) +
  geom_point(mapping = aes(x = balance, y = income, color = default), alpha = 0.4)
  # alpha: opacity, 0: transparent
```

### KNN

#### preprocessing

Split data into 80% training and 20% test.

```R
training <- Default %>%
    slice(1:8000)
test <- Default %>%
    slice(8001:10000)
```

Preprocess predictors of the training set, i.e., center and scale them.

```R
training <- training %>% 
  mutate(
    balance = scale(balance),
    income = scale(income)
  )

head(training)
```

#### training

preds <- kknn(default ~., train = training, test = test, k = 7)

#### prediction

classes of the k nearest neighbors

```R
head(preds$CL)
```

calculate the probabilities of defaulting

```R
head(preds$prob)
```

Or the predicted hard labels.

```R
head(preds$fitted.values)
```

#### evaluation

```R
decision_thershold <- 0.5
test_w_probs <- cbind(test, prob = preds$prob[,2])
test_w_probs$pred_binary <- as.factor(ifelse(test_w_probs$prob > decision_threshold, "Yes", "No"))
```

Evaluate predictive accuracy of the model on the test set.

```R
confusionMatrix(test_w_probs$default, reference=test_w_probs$pred_binary, positive="Yes", mode="prec_recall")
```

Simulate values for the two predictor variables, make predictions using these simulated values, and plot the resulting decision boundary.

```R
# generate a grid of balance and income values
sim <- expand.grid(balance = seq(min(training[,2]-1), max(training[,2]+1), by = 0.1),
                   income =  seq(min(training[,3]-1), max(training[,3]+1), by = 0.1))

# for each generated balance-income pair, predict label
preds <- kknn(default ~., train = training, test = sim, k = 1)
preds <- preds$fitted.values

# transform 0/1 values to No/Yes values
sim_w_preds <- bind_rows(mutate(sim,
                           label = "Yes",
                           prob_cls = ifelse(preds == label, 1, 0)),
                    mutate(sim,
                           label = "No",
                           prob_cls = ifelse(preds == label, 1, 0)))

# plot training data, simulated data, and decision boundary
ggplot() +
  geom_point(data = training,
             aes(x = balance, y = income, color = default),
             size = 3, alpha = 0.5) +
  geom_point(data = sim,
             aes(x = balance, y = income, color = preds),
             size = 0.5) + 
  geom_contour(data = sim_w_preds,
               aes(x = balance, y = income, z = prob_cls, group = label, color = label),
               bins = 1, size = 1) +
  labs(x = "balance", y = "income")
```
