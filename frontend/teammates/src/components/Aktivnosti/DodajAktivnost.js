import { Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";
import { useNavigate } from "react-router-dom";

const DodajAktivnost = () => {
  const [naziv, setNaziv] = useState("");
  const [opis, setOpis] = useState("");
  let navigate = useNavigate();

  const dodajAktivnost = () => {
    api
      .post("/aktivnosti", {
        naziv: naziv,
        opis: opis,
      })
      .then((result) => console.log(result.data));
    setNaziv("");
    setOpis("");
    navigate("/aktivnosti");
  };

  return (
    <div>
      <h2>Dodajanje aktivnosti</h2>
      <TextField
        label="Naziv"
        variant="outlined"
        value={naziv}
        onChange={(event) => setNaziv(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <TextField
        label="Opis"
        variant="outlined"
        value={opis}
        onChange={(event) => setOpis(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <Button
        variant="contained"
        color="success"
        onClick={dodajAktivnost}
        style={{ margin: "1rem" }}
      >
        Dodaj
      </Button>
      <Button
        variant="contained"
        style={{ margin: "1rem" }}
        onClick={() => navigate("/aktivnosti")}
      >
        Nazaj
      </Button>
    </div>
  );
};
export default DodajAktivnost;