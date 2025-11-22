
# ✅ 3. **Git Branching Strategy (Recommended for Automation Teams)**

### **Main branches**

| Branch      | Purpose                                    |
| ----------- | ------------------------------------------ |
| **main**    | Stable, production-ready automation code   |
| **develop** | Active development branch for new features |

---

### **Working branches**

| Branch Type | Naming Convention              | Use Case                                      |
| ----------- | ------------------------------ | --------------------------------------------- |
| **Feature** | `feature/<jira-id>-short-desc` | New API tests, utilities, modules             |
| **Bugfix**  | `bugfix/<jira-id>-fix-desc`    | Fix a broken automation test or framework bug |
| **Hotfix**  | `hotfix/<issue-desc>`          | Critical fix on `main`                        |
| **Release** | `release/x.x.x`                | Preparing a versioned release                 |

---

# 🔄 Typical Workflow

1. Create a feature branch

   ```
   git checkout develop
   git checkout -b feature
   
//API-123-add-user-tests
   ```

2. Commit and push changes

   ```
   git add .
   git commit -m "API-123: Added Create User API tests"
   git push -u origin feature/API-123-add-user-tests
   ```

3. Create a Pull Request → merge into `develop`

4. After testing, merge `develop` → `main`

---
