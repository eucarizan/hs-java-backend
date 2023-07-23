# Dolly

- [Dolly](#dolly)
  - [Learning Outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Clone](#1-clone)
      - [1.1 Description](#11-description)
      - [1.2 Objectives](#12-objectives)
      - [1.3 Solution](#13-solution)
    - [2: List the content](#2-list-the-content)
      - [2.1 Description](#21-description)
      - [2.2 Objectives](#22-objectives)
      - [2.3 Solution](#23-solution)
    - [3: A new Branch](#3-a-new-branch)
      - [3.1 Description](#31-description)
      - [3.2 Objectives](#32-objectives)
      - [3.3 Solution](#33-solution)
    - [4: Let's see what's inside](#4-lets-see-whats-inside)
      - [4.1 Description](#41-description)
      - [4.2 Objective](#42-objective)
      - [4.3 Solution](#43-solution)
    - [5: A new function](#5-a-new-function)
      - [5.1 Description](#51-description)
      - [5.2 Objectives](#52-objectives)
      - [5.3 Solution](#53-solution)
    - [6: Stage and commit](#6-stage-and-commit)
      - [6.1 Description](#61-description)
      - [6.2 Objectives](#62-objectives)
      - [6.3 Solution](#63-solution)
    - [7: Merge](#7-merge)
      - [7.1 Description](#71-description)
      - [7.2 Objectives](#72-objectives)
      - [7.3 Solution](#73-solution)
    - [8: Push](#8-push)
      - [8.1 Description](#81-description)
      - [8.2 Objectives](#82-objectives)
      - [8.3 Solution](#83-solution)

## Learning Outcomes
Learn how to use main git commands, including cloning, creation of branches, merging, and pushing changes to a remote depository.

## About
In 1996 The Roslin Institute from Scotland cloned a sheep called Dolly. A big step in the history of humankind. You don't need to clone a sheep in this project, don't worry. Instead of Dolly, clone a remote repository. A clone is a copy of a repository, created in a new directory. The aim is usually to make a local copy of a remote repository that is hosted on a third-party service. After this, you can work on your local copy, make changes, and push the changes back.

## Stages
### 1: Clone
#### 1.1 Description
You have joined a new project. The project files are located in a remote repository. Your task is to clone this repository into your current working directory. The URL of the remote repository is `file:///tmp/dolly`.

```
While working on this project, you will use a few Bash commands in addition to Git commands.
```

#### 1.2 Objectives
- Use the suitable Git command to clone the repository

#### 1.3 Solution
```shell
>git clone file:///tmp/dolly
```

### 2: List the content
#### 2.1 Description
In the previous stage, you cloned the project repository from a remote repo to the local directory `dolly`. Now, change the directory to it and list the content.

#### 2.2 Objectives
Let's break this task into several steps:
- Change the directory to `dolly`;
- List the files and directories inside `dolly`.

#### 2.3 Solution
```shell
>cd dolly
>ls
```

### 3: A new Branch
#### 3.1 Description
You've discovered the project files; they are included below. Before working on the project files, create a new local branch.
```
+-- dolly
|    +-- main.py
|    +-- readme.md
```

#### 3.2 Objectives
Let's break this task into several steps:
- Create a branch with the name `dev-mul` and checkout to it;
- Use the Git `branch` command to see the available and current branches.

#### 3.3 Solution
Solution 3.3.1:
```shell
>git branch dev-mul
>git checkout dev-mul
>git branch --list
```

Solution 3.3.2:
```shell
>git checkout -b dev-mul
>git branch --list
```

Solution 3.3.3:
```shell
>git checkout -b dev-mul
>git branch -a
```

### 4: Let's see what's inside
#### 4.1 Description
Your project branches can be seen in the code snippet. Right now, you work on the `dev-mul` branch, marked with an asterisk.
```
* dev-mul
main
```

As you remember, there are two files in your project. You will modify one of them in the next stage. But first, study the content. As you might guess, the file name is _main.py_.

#### 4.2 Objective
- Use the `cat` command to view the content of the file mentioned in the Description stage;

#### 4.3 Solution
```shell
>cat main.py
```

### 5: A new function
#### 5.1 Description
The current content of the _main.py_ can be seen in the code snippet. Follow the instructions to modify the file's content.

```python
def add(num1, num2):
    return num1 + num2
```

Now, add another function to _main.py_. There are two lines of code in the code snippet below. Add them to the file.

```python
def mul(num1, num2):
    return num1 * num2
```

#### 5.2 Objectives
Let's break this tasks into several steps:
- Add the lines to the file using `echo` command;
- View the content of the file;
- Use the Git `status` command to display the current state of your working directory.

#### 5.3 Solution
Solution 5.3.1:
```shell
>echo "def mul(num1, num2):" >> main.py
>echo "    return num1 * num2" >> main.py
>cat main.py
>git status
```

Solution 5.3.2:
```shell
>echo -e "def mul(num1, num2):\n    return num1 * num2" >> main.py
>cat main.py
>git status
```

### 6: Stage and commit
#### 6.1 Description
You have modified one of your files in the last stage. Now, commit the changes with a nice commit message.

#### 6.2 Objectives
Let's break this task into several steps:
- Add the modified file to the staging area;
- Commit your changes with the commit message: `New function multiplication`.

#### 6.3 Solution
```shell
>git add .
>git commit -m "New function multiplication"
```

### 7: Merge
#### 7.1 Description
You're done with the `dev-mul` branch. Now, merge the changes to the `main` branch.

#### 7.2 Objectives
Let's break this task into several steps:
- Check out the `main` branch;
- Merge the changes from the `dev-mul` branch;
- Delete the `dev-mul` branch.

#### 7.3 Solution
```shell
>git checkout main
>git merge dev-mul
>git branch -d dev-mul
```

### 8: Push
#### 8.1 Description
There's one step left. To share the changes with your team, you need to push them to the remote branch. But before doing it, take a look at the changes you've made.

#### 8.2 Objectives
Let's break this task into several steps:
- With the help of the Git `diff` commaind, view the changes between the previous and the last commit.
- Push the changes to the remote;

Use the `git diff HEAD~` command to view the changes between the previous and last commit.

#### 8.3 Solution
```shell
>git diff HEAD~
>git push
```