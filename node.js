const express = require("express");
const child_process = require("child_process");

const app = express();

app.use(express.urlencoded({ extended: true }));

app.post("/ping", (req, res) => {

    const host = req.body.host;

    child_process.exec(
        "ping -c 1 " + host,
        (err, stdout, stderr) => {

            if (err) {
                return res.send(err.message);
            }

            res.send(stdout);
        }
    );
});

app.get("/comment", (req, res) => {

    const name = req.query.name;

    res.send(
        "<h1>Hello "
        + name
        + "</h1>"
    );
});

app.listen(3000);
