import os
from datetime import datetime


def get_problem_directories():
    """Scan the src directory for problem folders"""
    base_dir = "src"
    problems = []

    if os.path.exists(base_dir):
        for dir_name in sorted(os.listdir(base_dir)):
            dir_path = os.path.join(base_dir, dir_name)
            if os.path.isdir(dir_path):
                problems.append({"name": dir_name, "path": dir_path})
    return problems


def update_readme(problems):
    """Generate and update the README.md file"""
    with open("README.md", "w") as f:
        f.write("# LeetCode Java Solutions\n\n")
        f.write(f"Last updated: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n\n")
        f.write("## Problems Solved\n\n")

        f.write("| Problem | Solution |\n")
        f.write("|---------|----------|\n")

        for problem in problems:
            problem_name = problem["name"].replace("-", " ").title()
            solution_path = problem["path"]
            f.write(f"| {problem_name} | [View Solution]({solution_path}) |\n")


if __name__ == "__main__":
    problems = get_problem_directories()
    update_readme(problems)
