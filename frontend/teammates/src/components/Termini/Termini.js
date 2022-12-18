import React, { useEffect, useState } from "react";
import api from "../../services/api";
import TerminiTable from "./TerminiTable";
import { Link } from "react-router-dom";
import { Button } from "@mui/material";

const Termini = () => {
  const [termini, setTermini] = useState([]);
  useEffect(() => {
    const pridobiTermine = () => {
      api.get("/termini").then((result) => {
        setTermini(result.data);
      });
    };
    pridobiTermine();
  }, []);

  return (
    <>
      <h1>Termini</h1>
      <TerminiTable termini={termini} />
      <Link style={{ textDecoration: "none" }} to="/termini/dodaj">
        <Button style={{ margin: "2rem" }} color="success" variant="contained">
          Dodaj termin
        </Button>
      </Link>
    </>
  );
};
export default Termini;
