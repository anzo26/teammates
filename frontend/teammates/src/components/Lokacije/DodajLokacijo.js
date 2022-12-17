import { Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";
import { useNavigate } from "react-router-dom";

const DodajLokacijo = () => {
  const [naslov, setNaslov] = useState("");
  const [regija, setRegija] = useState("");
  const [posta, setPosta] = useState("");
  let navigate = useNavigate();

  const dodajLokacijo = () => {
    api
      .post("/lokacije", {
        naslov: naslov,
        regija: regija,
        posta: posta,
      })
      .then((result) => console.log(result.data));
    setNaslov("");
    setRegija("");
    setPosta("");
    navigate("/lokacije");
  };

  return (
    <div>
      <h2>Dodajanje lokacije</h2>
      <TextField
        label="Naslov"
        variant="outlined"
        value={naslov}
        onChange={(event) => setNaslov(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <TextField
        label="Regija"
        variant="outlined"
        value={regija}
        onChange={(event) => setRegija(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <TextField
        label="Pošta"
        variant="outlined"
        value={posta}
        onChange={(event) => setPosta(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <Button
        variant="contained"
        color="success"
        onClick={dodajLokacijo}
        style={{ margin: "1rem" }}
      >
        Dodaj
      </Button>
      <Button
        variant="contained"
        style={{ margin: "1rem" }}
        onClick={() => navigate("/lokacije")}
      >
        Nazaj
      </Button>
    </div>
  );
};
export default DodajLokacijo;
