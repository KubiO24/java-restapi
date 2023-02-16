import com.google.gson.Gson;
import controller.UserServiceImpl;
import model.User;

import java.util.HashMap;
import static spark.Spark.*;
import spark.Request;
import spark.Response;


public class App {
    private static HashMap<String, User> users = new HashMap<>();
    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static void main(String[] args) {
        port(7777);
        get("/api/users", (req, res) -> userList(req, res));
        post("/api/users", (req, res) -> addUser(req, res));
    }

    static String userList(Request req, Response res) {
        res.type("application/json");
        Gson gson = new Gson();
        return gson.toJson(users);
    }

    static String addUser(Request req, Response res) {
        Gson gson = new Gson();
        User user = gson.fromJson(req.body(), User.class);
        users.put(user.getId(), user);
        return "dodano: " + req.body();
    }
}
