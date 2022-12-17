import React, { useEffect, useState } from "react";
import api from "../../services/api";
import { useParams } from "react-router-dom";
import { Button, TextField } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { Delete } from "@mui/icons-material";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

const odstraniLokacijo = (id) => {
  console.log(id);
  api.delete(`/lokacije/${id}`);
  window.location.reload();
};

export default function FiltriraneLokacije() {
  let { Pnaslov, Pregija, Pposta } = useParams();
  const [lokacije, setLokacije] = useState([]);
  let navigate = useNavigate();

  useEffect(() => {
    api.get(`/lokacije/${Pnaslov}/${Pregija}/${Pposta}`).then((result) => {
      setLokacije(result.data);
    });
  }, []);

  return (
    <>
      <h1>Lokacije</h1>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>
                <strong>Id</strong>
              </TableCell>
              <TableCell align="center">
                <strong>Naslov</strong>
              </TableCell>
              <TableCell align="center">
                <strong>Regija</strong>
              </TableCell>
              <TableCell align="center">
                <strong>Pošta</strong>
              </TableCell>
              <TableCell align="center"></TableCell>
              <TableCell align="center"></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {lokacije.map((Lokacija) => (
              <TableRow
                key={Lokacija.id}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {Lokacija.id}
                </TableCell>
                <TableCell align="center">{Lokacija.naslov}</TableCell>
                <TableCell align="center">{Lokacija.regija}</TableCell>
                <TableCell align="center">{Lokacija.posta}</TableCell>
                <TableCell align="left">
                  {
                    <Button
                      variant="contained"
                      onClick={() => navigate(`/lokacije/${Lokacija.id}`)}
                    >
                      Uredi
                    </Button>
                  }
                </TableCell>
                <TableCell align="left">
                  {
                    <Button
                      variant="contained"
                      color="error"
                      startIcon={<Delete />}
                      onClick={() => odstraniLokacijo(Lokacija.id)}
                    >
                      Odstrani
                    </Button>
                  }
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      <div>
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
