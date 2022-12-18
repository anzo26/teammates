import { Button, TextField } from "@mui/material";
import React, { useState } from "react";
import api from "../../services/api";
import { useNavigate } from "react-router-dom";

const DodajTermin = () => {
  const [opis, setOpis] = useState("");
  const [zacetek, setZacetek] = useState("");
  const [stevilo_mest, setStevilo_mest] = useState("");
  let navigate = useNavigate();

  const dodajTermin = () => {
    api
      .post("/termini/lokacija/2/aktivnost/2", {
        opis: opis,
        zacetek: zacetek,
        stevilo_mest: stevilo_mest,
      })
      .then((result) => console.log(result.data));
    setOpis("");
    setZacetek("");
    setStevilo_mest("");
    navigate("/termini");
  };

  return (
    <div>
      <h2>Dodajanje termina</h2>
      <TextField
        label="Opis"
        variant="outlined"
        value={opis}
        onChange={(event) => setOpis(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <TextField
        label="Začetek"
        variant="outlined"
        value={zacetek}
        onChange={(event) => setZacetek(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <TextField
        label="Število mest"
        variant="outlined"
        value={stevilo_mest}
        onChange={(event) => setStevilo_mest(event.target.value)}
        style={{ margin: "1rem" }}
      />
      <br />
      <Button
        variant="contained"
        color="success"
        onClick={dodajTermin}
        style={{ margin: "1rem" }}
      >
        Dodaj
      </Button>
      <Button
        variant="contained"
        style={{ margin: "1rem" }}
        onClick={() => navigate("/termini")}
      >
        Nazaj
      </Button>
    </div>
  );
};
export default DodajTermin;