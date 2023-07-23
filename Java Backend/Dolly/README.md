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
```console
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
```console
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
```console
>git branch dev-mul
>git checkout dev-mul
>git branch --list
```

Solution 3.3.2:
```console
>git checkout -b dev-mul
>git branch --list
```

Solution 3.3.3:
```console
>git checkout -b dev-mul
>git branch -a
```