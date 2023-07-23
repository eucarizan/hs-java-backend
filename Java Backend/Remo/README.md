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
    - [3: Create files](#3-create-files)
      - [Description](#description-2)
      - [Objectives](#objectives-2)
    - [4: Ignore it](#4-ignore-it)
      - [Description](#description-3)
      - [Objectives](#objectives-3)
    - [5: Commit](#5-commit)
      - [Description](#description-4)
      - [Objectives](#objectives-4)

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

### 3: Create files
#### Description
An empty repository doesn't make much sense. Let's add some files to work with.

There is a Bash command called `echo`. This command in Bash is used to display a line of text/string that is passed as an argument. But with the help of the `echo` command you can create files with content in it or add content to an existing file. In this project stage, you will do both.

First, create a Python file with the name `main.py` and with the following content `print('Hello world')`. If there is an existing file with the same name, overwrite it and replace the file's content.

If you run this file in an environment where Python is installed, it will print `Hello world` to the standard output. But this is just some information; your task is not to run this file.

Now there is another file with the name `.env`. Add the following text to it `PASSWORD=Ax?bu75+33`. But be aware, don't delete the existing file; add the content to it.

You can use .env files to store environmental variables, like URLs, API keys, and secrets.

#### Objectives
- Create the first file;
- Add content to the second file.

### 4: Ignore it
#### Description
It is essential not to commit/push uncalled-for files or files containing secrets. Mainly when you work with public repositories. Hopefully, there is a way to avoid it. You can add file and directory names to the `.gitignore`, and they will not be committed or pushed. In the last stage, you have added a secret line to a _.env_ file. Now add the _.env_ file to the `.gitignore`:

```
You can use "git status --help" command to see available options and get help.
```

#### Objectives
- Add a _.env_ file to `.gitignore`;
- Use the `git status` command with the suitable option to list the ignored files.

### 5: Commit
#### Description
In this stage, make your first commit. First, add the files to the staging area and commit them afterward. Your commit message should be `Initial commit`.

#### Objectives
- Stage your files;
- Commit the changes with a message.

[git config]: https://git-scm.com/book/en/v2/Customizing-Git-Git-Configuration