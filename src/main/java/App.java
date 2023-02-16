import com.google.gson.Gson;
import controller.UserServiceImpl;
import model.User;

import java.util.HashMap;
import java.util.Objects;

import static spark.Spark.*;
import spark.Request;
import spark.Response;


public class App {
    private static final UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {
        port(7777);
        get("/api/users", App::userList);
        get("/api/users/:id", App::user);
        post("/api/users", App::addUser);
        options("/api/users/:id", App::userExist);
        delete("/api/users/:id", App::deleteUser);
    }

    static String userList(Request req, Response res) {
        res.type("application/json");
        Gson gson = new Gson();
        return gson.toJson(userServiceImpl.getUsers());
    }

    static String user(Request req, Response res) {
        res.type("application/json");
        Gson gson = new Gson();
        String id = req.params("id");
        String userData = gson.toJson(userServiceImpl.getUser(id));
        if(Objects.equals(userData, "null"))
            return "{}";
        return "user: " + userData;
    }

    static String addUser(Request req, Response res) {
        Gson gson = new Gson();
        User user = gson.fromJson(req.body(), User.class);
        userServiceImpl.addUser(user);
        return "added: " + req.body();
    }

    static Boolean userExist(Request req, Response res) {
        String id = req.params("id");
        return userServiceImpl.userExist(id);
    }

    static String deleteUser(Request req, Response res) {
        String id = req.params("id");
        userServiceImpl.deleteUser(id);
        return "deleted user with id=" + id;
    }
}
