# Remo

- [Remo](#remo)
  - [Learning Outcomes](#learning-outcomes)
  - [About](#about)
  - [Stages](#stages)
    - [1: Global settings](#1-global-settings)
      - [Description](#description)
      - [Objectives](#objectives)
    - [2: Initialize](#2-initialize)
      - [Description](#description-1)
      - [Objectives](#objectives-1)

## Learning Outcomes
Learn the basic git commands. Initialize a repository, stage your changes, and do commits. Study how to "ignore" unnecessary files.

## About
Remote is a git repository to store and exchange changes. It is a store that allows you to work from different places. In this project, you will examine basic git commands and how to work with a remote.

## Stages
### 1: Global settings
#### Description
When you install the `Git` utility on your system, the first thing you need to do is to define the global variables. They can be defined with a `git config` command followed by `--global` option, a `variable name`, and a `value`. This means every git repository created on your system after that will have these variables pre-defined. Below you will find a simple usage of the command. To learn more about it, you can follow the link [git configuration][git config] for official documentation.

```console
git config --global <variable name> <value>
```

The `config` command without a value will show you the value of the variable.

#### Objectives
- Define a global variable with the name `user.name` and with the value `hyper`;
- Define a global variable with the name `user.email` and with the value `hyperskill@hyperskill.org`;
- Define a global variable with the name `init.defaultBranch` and with the value `main`;
- Use the `config` command to view the user email.

### 2: Initialize
#### Description
Create an empty repository and add `remote` for it. You can use the command below to add a remote.

```console
git remote add <name for the remote> <remote URL>
```

The name of the remote can be anything. But, it is a convention to use `origin`.

#### Objectives
Let's break this task into a few steps:
- In the current working directory, initialize an empty `Git` repository;
- Add `remote` to your repository, with the name `origin` and with the URL `file:///tmp/git-bare`.


[git config]: https://git-scm.com/book/en/v2/Customizing-Git-Git-Configuration