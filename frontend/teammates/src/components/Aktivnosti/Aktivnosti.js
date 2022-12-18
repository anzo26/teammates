import React, { useEffect, useState } from "react";
import api from "../../services/api";
import AktivnostiTable from "./AktivnostiTable";
import { Link } from "react-router-dom";
import { Button } from "@mui/material";

const Aktivnosti = () => {
  const [aktivnosti, setAktivnosti] = useState([]);
  useEffect(() => {
    const pridobiAktivnsoti = () => {
      api.get("/aktivnosti").then((result) => {
        setAktivnosti(result.data);
      });
    };
    pridobiAktivnsoti();
  }, []);

  return (
    <>
      <h1>Aktivnosti</h1>
      <AktivnostiTable aktivnosti={aktivnosti} />
      <Link style={{ textDecoration: "none" }} to="/aktivnosti/dodaj">
        <Button style={{ margin: "2rem" }} color="success" variant="contained">
          Dodaj aktivnost
        </Button>
      </Link>
    </>
  );
};
export default Aktivnosti;