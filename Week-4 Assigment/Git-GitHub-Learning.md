# Git & GitHub — Detailed Learning Guide

This guide expands the quick notes into a practical, hands-on reference for learning Git and GitHub. It covers setup, core concepts, commands, common workflows, conflict resolution, and useful tips.

## 1. What is Git and GitHub?

- Git: a distributed version control system that tracks changes to files, enables branching, and stores a history of commits locally.
- GitHub: a cloud-based platform for hosting Git repositories, collaboration (pull requests, code reviews), issue tracking, and CI integrations.

## 2. Install & configure

1. Install Git: https://git-scm.com/
2. Configure global identity:

```
git --version
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
git config --global core.editor "code --wait"   # optional: set VS Code as editor
```

3. (Optional) Setup SSH key for GitHub:

```
ssh-keygen -t ed25519 -C "you@example.com"
# then add the public key (~/.ssh/id_ed25519.pub) to GitHub account settings
```

## 3. Basic local workflow

- Initialize a repo:

```
git init                # create a new repository
```

- Or clone an existing remote:

```
git clone https://github.com/OWNER/REPO.git
```

- Typical edit cycle:

```
git status
git add <file-or-dir>       # stage changes
git commit -m "Describe change concisely"
```

- View history:

```
git log --oneline --graph --decorate --all
```

## 4. The three states: working tree, index, repository

- Working tree: files you edit.
- Index (staging area): files staged with `git add`.
- Repository: committed snapshots stored as objects.

Commands to move between states:

```
git add <file>            # working -> index
git commit                # index -> repository
git restore <file>        # discard working changes
git restore --staged <file>  # remove from index
```

## 5. Branching & merging

- Create and switch:

```
git branch feature-x
git switch feature-x       # newer command
git checkout -b feature-x  # older combined command
```

- Merge:

```
git switch main
git merge feature-x
```

- Rebase (linear history):

```
git switch feature-x
git rebase main
```

When to use rebase vs merge: use rebase to keep a linear history for local cleanup; use merge for public branches to preserve merge commits.

## 6. Remote repositories & GitHub

- Add remote and push:

```
git remote add origin git@github.com:OWNER/REPO.git
git push -u origin main
git push origin feature-x
```

- Update local view of remote branches:

```
git fetch origin               # fetch refs but don't merge
git pull origin main           # fetch + merge (or use: git pull --rebase)
```

## 7. Fork & PR-based collaboration (common on GitHub)

1. Fork the upstream repo on GitHub.
2. Clone your fork locally.
3. Create a branch for your change (`feature/xyz`).
4. Push branch to your fork and open a Pull Request to upstream `main`.
5. Address review comments, push updates to the same branch.
6. Merge via GitHub when approved.

## 8. Resolving conflicts

- Conflicts occur when the same lines are changed on different branches. Steps to resolve:

```
# During merge or rebase you'll see conflict markers in files
# Edit files to resolve conflicts, then:
git add <resolved-files>
git rebase --continue   # if rebasing
git commit              # if merging
```

Tips: use `git status` to list conflicted files and `git diff` to inspect differences. Many editors (VS Code) show conflict UI.

## 9. Rewriting history (use carefully)

- Amend last commit:

```
git commit --amend -m "Fix message or include staged changes"
```

- Interactive rebase to edit multiple commits:

```
git rebase -i HEAD~N
```

- Reset (dangerous on shared branches):

```
git reset --hard <commit>   # move branch pointer and reset working tree
```

Only rewrite history on local or private branches; avoid rewriting commits that others have based work on.

## 10. Useful .gitignore patterns

```
# build artifacts
/target/
/build/

# IDE
.vscode/
.idea/

# OS
.DS_Store
Thumbs.db

# dependencies
node_modules/
```

## 11. Handy commands & aliases

- Show staged and unstaged changes:

```
git diff          # unstaged
git diff --staged # staged
```

- Undo local changes (safe):

```
git restore <file>
git restore --staged <file>
```

- Create an alias for a compact log:

```
git config --global alias.lg "log --oneline --graph --decorate --all"
git lg
```

## 12. Working with Git in VS Code

- Open the source control panel, stage files, enter commit messages, and use the branch picker. VS Code integrates with GitHub for PRs via extensions.

## 13. Best practices

- Make focused commits with clear messages.
- Use feature branches; keep `main` deployable.
- Pull/rebase frequently to minimize conflicts.
- Don't commit secrets — use environment variables or secrets managers.

## 14. Learning resources

- https://infyspringboard.onwingspan.com/web/en/app/toc/lex_auth_01384266074125107220863_shared/overview

