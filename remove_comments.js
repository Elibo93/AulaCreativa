const fs = require('fs');
const path = require('path');

function removeJavaComments(filePath) {
    let content = fs.readFileSync(filePath, 'utf8');
    // Regex for single line comments
    content = content.replace(/\s*\/\/.*$/gm, '');
    fs.writeFileSync(filePath, content, 'utf8');
}

function processJavaFiles(dirPath) {
    const files = fs.readdirSync(dirPath);
    for (const file of files) {
        const fullPath = path.join(dirPath, file);
        if (fs.statSync(fullPath).isDirectory()) {
            processJavaFiles(fullPath);
        } else if (fullPath.endsWith('.java')) {
            removeJavaComments(fullPath);
            console.log(`Cleaned Java file: ${fullPath}`);
        }
    }
}

function removeHtmlComments(filePath) {
    let content = fs.readFileSync(filePath, 'utf8');
    // Regex for HTML comments
    content = content.replace(/<!--[\s\S]*?-->/g, '');
    fs.writeFileSync(filePath, content, 'utf8');
}

function processHtmlFiles(dirPath) {
    const files = fs.readdirSync(dirPath);
    for (const file of files) {
        const fullPath = path.join(dirPath, file);
        if (fs.statSync(fullPath).isDirectory()) {
            processHtmlFiles(fullPath);
        } else if (fullPath.endsWith('.html')) {
            removeHtmlComments(fullPath);
            console.log(`Cleaned HTML file: ${fullPath}`);
        }
    }
}

// execute
processJavaFiles('src/main/java/es/etg/daw/dawes/java/rest/aulaCreativa/vista/infraestructure/web');
processHtmlFiles('src/main/resources/templates');

console.log('All comments removed.');
