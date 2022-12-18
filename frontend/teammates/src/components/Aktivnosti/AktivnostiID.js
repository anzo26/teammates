import React, { useEffect, useState } from "react";
import api from "../../services/api";
import { useParams } from "react-router-dom";
import { Button, TextField } from "@mui/material";
import { useNavigate } from "react-router-dom";

export default function AktivnostiID() {
  let { IdAktivnost } = useParams();
  const [naziv, setNaziv] = useState("");
  const [opis, setOpis] = useState("");
  let navigate = useNavigate();

  useEffect(() => {
    api.get(`/aktivnosti/${IdAktivnost}`).then((result) => {
      setNaziv(result.data.naziv);
      setOpis(result.data.opis);
    });
  }, []);

  const urediAktivnost = () => {
    api
      .put(`/aktivnosti/${IdAktivnost}`, {
        naziv: naziv,
        opis: opis,
      })
      .then((result) => console.log(result.data));
    navigate("/aktivnosti");
  };
  return (
    <>
      <div>
        <h2>Urejanje aktivnosti</h2>
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
          onClick={urediAktivnost}
          style={{ margin: "1rem" }}
        >
          Uredi
        </Button>
        <Button
          variant="contained"
          style={{ margin: "1rem" }}
          onClick={() => navigate("/aktivnosti")}
        >
          Nazaj
        </Button>
      </div>
    </>
  );
}