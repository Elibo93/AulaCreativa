import os
import re

folder = 'src/main/resources/templates/fragments/content'

for filename in os.listdir(folder):
    if not filename.endswith('.html'):
        continue
    filepath = os.path.join(folder, filename)
    with open(filepath, 'r', encoding='utf-8') as f:
        html = f.read()

    body_content_match = re.search(r'<main[^>]*>(.*?)</main>(.*?)</body>', html, re.DOTALL | re.IGNORECASE)
    
    if body_content_match:
        main_inner = body_content_match.group(1)
        after_main = body_content_match.group(2)
        
        # Remove the fragments/scripts include since the layout already has it
        after_main_clean = re.sub(r'<div th:replace="[^"]*fragments/scripts[^"]*"></div>', '', after_main, flags=re.IGNORECASE)
        
        combined_content = main_inner + "\n" + after_main_clean.strip()
        
        new_html = f'''<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="es">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <div th:fragment="content">
{combined_content}
    </div>
</body>
</html>'''
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(new_html)
        print(f"Refactored {filename}")
    else:
        print(f"Skipped {filename} (No <main> tag found)")
