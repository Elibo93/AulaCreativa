const fs = require('fs');
const path = require('path');

const folder = 'src/main/resources/templates/fragments/content';
const files = fs.readdirSync(folder);

for (const file of files) {
    if (!file.endsWith('.html')) continue;

    const filepath = path.join(folder, file);
    const html = fs.readFileSync(filepath, 'utf8');

    const bodyMatch = html.match(/<main[^>]*>([\s\S]*?)<\/main>([\s\S]*?)<\/body>/i);
    if (bodyMatch) {
        const mainInner = bodyMatch[1];
        let afterMain = bodyMatch[2];

        afterMain = afterMain.replace(/<div th:replace="[^"]*fragments\/scripts[^"]*"><\/div>/gi, '');

        const combined = mainInner + '\n' + afterMain.trim();
        const newHtml = `<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="es">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <div th:fragment="content">
${combined}
    </div>
</body>
</html>`;
        fs.writeFileSync(filepath, newHtml, 'utf8');
        console.log(`Refactored ${file}`);
    } else {
        console.log(`Skipped ${file}`);
    }
}
