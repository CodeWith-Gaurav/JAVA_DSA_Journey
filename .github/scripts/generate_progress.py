import os

TEMPLATE_PATH = "progress_template.md"
OUTPUT_PATH = "PROGRESS.md"

MODULES = [
    "01_Basics",
    "02_Conditionals_Loops",
    "03_Functions_Arrays",
    "04_Sorting_Searching",
    "05_Recursion",
    "06_Backtracking",
    "07_LinkedLists",
    "08_Stacks_Queues",
    "09_Trees",
    "10_Hashing",
    "11_Graphs",
    "12_BitManipulation",
    "13_Greedy_Algorithms",
    "14_DynamicProgramming",
    "15_Revision"
]

def get_status(folder):
    if os.path.exists(f"{folder}/done.txt"):
        return "Completed", "brightgreen"
    elif os.path.exists(f"{folder}/in_progress.txt"):
        return "In Progress", "yellow"
    else:
        return "Pending", "lightgrey"

badges = []
for mod in MODULES:
    status, color = get_status(mod)
    label = mod.replace("_", "%20")
    badge_url = f"https://img.shields.io/badge/{label}-{status.replace(' ', '%20')}-{color}"
    badges.append(f"![{mod}]({badge_url})")

with open(TEMPLATE_PATH, "r") as f:
    content = f.read()

start = content.find("<!--PROGRESS_BADGES_START-->") + len("<!--PROGRESS_BADGES_START-->\n")
end = content.find("<!--PROGRESS_BADGES_END-->")
new_content = content[:start] + "\n".join(badges) + "\n" + content[end:]

with open(OUTPUT_PATH, "w") as f:
    f.write(new_content)
