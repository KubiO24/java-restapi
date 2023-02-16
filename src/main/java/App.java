import com.google.gson.Gson;
import controller.UserServiceImpl;
import model.User;

import java.util.HashMap;
import static spark.Spark.*;
import spark.Request;
import spark.Response;


public class App {
    private static final HashMap<String, User> users = new HashMap<>();
    private static final UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {
        port(7777);
        get("/api/users", App::userList);
        get("/api/users/:id", App::user);
        post("/api/users", App::addUser);
    }

    static String userList(Request req, Response res) {
        res.type("application/json");
        Gson gson = new Gson();
        return gson.toJson(users);
    }

    static String user(Request req, Response res) {
        res.type("application/json");
        Gson gson = new Gson();
        String id = req.params("id");
        String userData = gson.toJson(users.get(id));
        return "user: " + userData;
    }

    static String addUser(Request req, Response res) {
        Gson gson = new Gson();
        User user = gson.fromJson(req.body(), User.class);
        users.put(user.getId(), user);
        return "dodano: " + req.body();
    }
}
