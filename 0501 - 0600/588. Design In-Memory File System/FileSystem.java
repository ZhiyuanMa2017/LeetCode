import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileSystem {
    File root;

    public FileSystem() {
        root = new File("");
    }

    public List<String> ls(String path) {
        return findFile(path).getLs();
    }

    public void mkdir(String path) {
        findFile(path);
    }

    public void addContentToFile(String filePath, String content) {
        findFile(filePath).addContent(content);
    }

    public String readContentFromFile(String filePath) {
        return findFile(filePath).getContent();
    }

    private File findFile(String path) {
        if (path.equals("/")) {
            return root;
        }
        String[] files = path.split("/");
        File cur = root;
        for (int i = 1; i < files.length; i++) {
            String fileName = files[i];

            cur.children.putIfAbsent(fileName, new File(fileName));
            cur = cur.children.get(fileName);
        }
        return cur;
    }

    private class File {
        private Map<String, File> children;
        private StringBuilder content;
        private String fileName;

        public File(String name) {
            children = new HashMap<>();
            content = new StringBuilder();
            fileName = name;
        }


        public String getContent() {
            return content.toString();
        }

        public void addContent(String contents) {
            this.content.append(contents);
        }

        public String getFileName() {
            return fileName;
        }

        public List<String> getLs() {
            if (content.length() > 0) {
                return new ArrayList<>(List.of(getFileName()));
            } else {
                List<String> res = new ArrayList<>(children.keySet());
                Collections.sort(res);
                return res;
            }
        }
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        System.out.println(fileSystem.ls("/"));
        fileSystem.mkdir("/a/b/c");
        System.out.println(fileSystem.ls("/"));
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
