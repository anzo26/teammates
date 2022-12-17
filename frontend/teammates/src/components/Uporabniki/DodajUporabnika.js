import { Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";
import { useNavigate } from "react-router-dom";

const DodajUporabnika = () => {
  const [ime, setIme] = useState("");
  const [priimek, setPriimek] = useState("");
  const [email, setEmail] = useState("");
  const [uporabnisko_ime, setUporabnisko_ime] = useState("");
  let navigate = useNavigate();

  const dodajUporabnika = () => {
    api
      .post(`/uporabniki/lokacija/60`, {
        ime: ime,
        priimek: priimek,
        email: email,
        uporabnisko_ime: uporabnisko_ime,
      })
      .then((result) => console.log(result.data));
    setIme("");
    setPriimek("");
    setEmail("");
    setUporabnisko_ime("");
    navigate("/uporabniki");
  };

  return (
    <div>
      <h2>Dodajanje Uporabnika</h2>
      <TextField
        label="Ime"
        variant="outlined"
        value={ime}
        onChange={(event) => setIme(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <TextField
        label="Priimek"
        variant="outlined"
        value={priimek}
        onChange={(event) => setPriimek(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <TextField
        label="E-mail"
        variant="outlined"
        value={email}
        onChange={(event) => setEmail(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <TextField
        label="Uporabniško ime"
        variant="outlined"
        value={uporabnisko_ime}
        onChange={(event) => setUporabnisko_ime(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <Button
        variant="contained"
        color="success"
        onClick={dodajUporabnika}
        style={{ margin: "1rem" }}
      >
        Dodaj
      </Button>
      <Button
        variant="contained"
        style={{ margin: "1rem" }}
        onClick={() => navigate("/uporabniki")}
      >
        Nazaj
      </Button>
    </div>
  );
};
export default DodajUporabnika;
