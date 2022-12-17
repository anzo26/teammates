import React, { useEffect, useState } from "react";
import api from "../../services/api";
import { useParams } from "react-router-dom";
import { Button, TextField } from "@mui/material";
import { useNavigate } from "react-router-dom";

export default function UporabnikiID() {
  let { IdUporabnik } = useParams();
  const [ime, setIme] = useState("");
  const [priimek, setPriimek] = useState("");
  const [email, setEmail] = useState("");
  const [uporabnisko_ime, setUporabnisko_ime] = useState("");
  let navigate = useNavigate();

  useEffect(() => {
    api.get(`/uporabniki/${IdUporabnik}`).then((result) => {
      setIme(result.data.ime);
      setPriimek(result.data.priimek);
      setEmail(result.data.email);
      setUporabnisko_ime(result.data.uporabnisko_ime);
    });
  }, []);

  const urediLokacijo = () => {
    api
      .put(`/uporabniki/${IdUporabnik}`, {
        ime: ime,
        priimek: priimek,
        email: email,
        uporabnisko_ime: uporabnisko_ime,
      })
      .then((result) => console.log(result.data));
    navigate("/uporabniki");
  };
  return (
    <>
      <div>
        <h2>Urejanje uporabnika</h2>
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
          onClick={urediLokacijo}
          style={{ margin: "1rem" }}
        >
          Uredi
        </Button>
        <Button
          variant="contained"
          style={{ margin: "1rem" }}
          onClick={() => navigate("/uporabniki")}
        >
          Nazaj
        </Button>
      </div>
    </>
  );
}
