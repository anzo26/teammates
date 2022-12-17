import React, { useEffect, useState } from "react";
import api from "../../services/api";
import UporabnikiTable from "./UporabnikiTable";
import { Link } from "react-router-dom";
import { Button } from "@mui/material";

const Uporabniki = () => {
  const [uporabniki, setUporabniki] = useState([]);
  useEffect(() => {
    const pridobiUporabnike = () => {
      api.get("/uporabniki").then((result) => {
        setUporabniki(result.data);
      });
    };
    pridobiUporabnike();
  }, []);

  return (
    <>
      <h1>Uporabniki</h1>
      <UporabnikiTable uporabniki={uporabniki} />
      <Link style={{ textDecoration: "none" }} to="/uporabniki/dodaj">
        <Button style={{ margin: "2rem" }} color="success" variant="contained">
          Dodaj uporabnika
        </Button>
      </Link>
    </>
  );
};
export default Uporabniki;
