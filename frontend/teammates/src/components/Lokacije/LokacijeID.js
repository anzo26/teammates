import React, { useEffect, useState } from "react";
import api from "../../services/api";
import { useParams } from "react-router-dom";
import { Button, TextField } from "@mui/material";
import { useNavigate } from "react-router-dom";

export default function LokacijeID() {
  let { IdLokacija } = useParams();
  const [naslov, setNaslov] = useState("");
  const [regija, setRegija] = useState("");
  const [posta, setPosta] = useState("");
  let navigate = useNavigate();

  useEffect(() => {
    api.get(`/lokacije/${IdLokacija}`).then((result) => {
      setNaslov(result.data.naslov);
      setRegija(result.data.regija);
      setPosta(result.data.posta);
    });
  }, []);

  const urediLokacijo = () => {
    api
      .put(`/lokacije/${IdLokacija}`, {
        naslov: naslov,
        regija: regija,
        posta: posta,
      })
      .then((result) => console.log(result.data));
    navigate("/lokacije");
  };
  return (
    <>
      <div>
        <h2>Urejanje lokacije</h2>
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
          onClick={urediLokacijo}
          style={{ margin: "1rem" }}
        >
          Uredi
        </Button>
        <Button
          variant="contained"
          style={{ margin: "1rem" }}
          onClick={() => navigate("/lokacije")}
        >
          Nazaj
        </Button>
      </div>
    </>
  );
}
