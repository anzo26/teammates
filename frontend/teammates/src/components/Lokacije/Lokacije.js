import React, { useEffect, useState } from "react";
import api from "../../services/api";
import LokacijeTable from "./LokacijeTable";
import { Link } from "react-router-dom";
import { Button } from "@mui/material";

const Lokacije = () => {
  const [lokacije, setLokacije] = useState([]);
  useEffect(() => {
    const pridobiLokacije = () => {
      api.get("/lokacije").then((result) => {
        setLokacije(result.data);
      });
    };
    pridobiLokacije();
  }, []);

  return (
    <>
      <h1>Lokacije</h1>
      <LokacijeTable lokacije={lokacije} />
      <Link style={{ textDecoration: "none" }} to="/lokacije/dodaj">
        <Button style={{ margin: "2rem" }} color="success" variant="contained">
          Dodaj lokacijo
        </Button>
      </Link>
    </>
  );
};
export default Lokacije;
