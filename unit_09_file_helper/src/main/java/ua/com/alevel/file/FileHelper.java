package ua.com.alevel.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("C:\\Users\\User\\Documents");
        boolean exit = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!exit) {
            System.out.println("Choose an action:");
            System.out.println("1. View all files and folders");
            System.out.println("2. Create file or folder");
            System.out.println("3. Delete file or folder");
            System.out.println("4. Find a file or folder");
            System.out.println("5. Поиск текста в файлах");
            System.out.println("6. Finding text in files");
            System.out.println("7. exit");
            String choice = reader.readLine();
            switch (choice) {
                case "1":
                    listFiles(dir);
                    break;
                case "2":
                    createFile(dir);
                    break;
                case "3":
                    deleteDirectory(dir);
                    break;
                case "4":
                    searchFile(dir);
                    break;
                case "5":
                    searchForTextInFiles(dir);
                    break;
                case "6":
                    moveFileOrFolder(dir);
                    break;
                case "7":
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор!");
                    break;
            }
        }
    }

    public static void listFiles(Path directory) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Директория не существует.");
        }
    }

    public static void createFile(Path directory) throws IOException {
        System.out.println("Enter the name of the file or folder you want to create:");
        String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Path file = directory.resolve(name);
        if (Files.exists(file)) {
            System.out.println("The file or folder already exists!");
            return;
        }
        if (Files.isDirectory(file)) {
            Files.createDirectories(file);
            System.out.println("Folder created successfully!");
        } else {
            Files.createFile(file);
            System.out.println("File created successfully!");
        }
    }

    public static void deleteDirectory(Path directory) throws IOException {
        if (!Files.isDirectory(directory)) {
            System.out.println("The path is not a directory.");
            return;
        }
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file : stream) {
                if (Files.isDirectory(file)) {
                    deleteDirectory(file);
                } else {
                    Files.delete(file);
                }
            }
        }
        Files.delete(directory);
    }

    public static void searchFile(Path directory) throws IOException {
        System.out.println("Enter the name of the file or folder you want to find:");
        String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
        boolean found = false;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file : stream) {
                if (file.getFileName().toString().equals(name)) {
                    System.out.println("File or folder found: " + file);
                    found = true;
                    break;
                } else if (Files.isDirectory(file)) {
                    searchFile(file);
                }
            }
        }
        if (!found) {
            System.out.println("The file or folder was not found.");
        }
    }

    public static void moveFileOrFolder(Path directory) throws IOException {
        System.out.println("Enter the name of the file or folder you want to move:");
        String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Path source = directory.resolve(name);
        if (!Files.exists(source)) {
            System.out.println("The file or folder does not exist!");
            return;
        }
        System.out.println("Enter a new path to move the file or folder:");
        String newPath = new BufferedReader(new InputStreamReader(System.in)).readLine();
        Path destination = Paths.get(newPath);
        Files.move(source, destination);
        System.out.println("File or folder moved successfully!");
    }

    public static void searchForTextInFiles(Path directory) throws IOException {
        System.out.println("Enter text to search:");
        String searchText = new BufferedReader(new InputStreamReader(System.in)).readLine();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file : stream) {
                if (Files.isDirectory(file)) {
                    searchForTextInFiles(file);
                } else if (Files.isRegularFile(file)) {
                    if (Files.readAllLines(file).stream().anyMatch(line -> line.contains(searchText))) {
                        System.out.println("Found a match in the file:" + file);
                    }
                }
            }
        }
    }
}



