import React, { useEffect, useState } from "react";
import api from "../../services/api";
import { useParams } from "react-router-dom";
import { Button, TextField } from "@mui/material";
import { useNavigate } from "react-router-dom";

export default function TerminiID() {
  let { IdTermin } = useParams();
  const [opis, setOpis] = useState("");
  const [zacetek, setZacetek] = useState("");
  const [stevilo_mest, setStevilo_mest] = useState("");
  let navigate = useNavigate();

  useEffect(() => {
    api.get(`/termini/${IdTermin}`).then((result) => {
      setOpis(result.data.opis);
      setZacetek(result.data.zacetek);
      setStevilo_mest(result.data.stevilo_mest);
    });
  }, []);

  const urediTermin = () => {
    api
      .put(`/termini/${IdTermin}`, {
        opis: opis,
        zacetek: zacetek,
        stevilo_mest: stevilo_mest,
      })
      .then((result) => console.log(result.data));
    navigate("/termini");
  };
  return (
    <>
      <div>
        <h2>Urejanje termina</h2>
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
          onClick={urediTermin}
          style={{ margin: "1rem" }}
        >
          Uredi
        </Button>
        <Button
          variant="contained"
          style={{ margin: "1rem" }}
          onClick={() => navigate("/termini")}
        >
          Nazaj
        </Button>
      </div>
    </>
  );
}