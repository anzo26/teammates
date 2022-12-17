import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Button } from "@mui/material";
import { Delete } from "@mui/icons-material";
import api from "../../services/api";
import { useNavigate } from "react-router-dom";
import TextField from "@mui/material/TextField";
import React, { useState } from "react";

const odstraniLokacijo = (id) => {
  console.log(id);
  api.delete(`/lokacije/${id}`);
  window.location.reload();
};

export default function LokacijeTable({ lokacije }) {
  const [naslov, setNaslov] = useState("");
  const [regija, setRegija] = useState("");
  const [posta, setPosta] = useState("");
  let navigate = useNavigate();

  return (
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
          <TableRow>
            <TableCell></TableCell>
            <TableCell align="center">
              <TextField
                id="outlined-search"
                label="Išči naslov"
                type="search"
                onChange={(event) => setNaslov(event.target.value)}
              />
            </TableCell>
            <TableCell align="center">
              <TextField
                id="outlined-search"
                label="Išči regijo"
                type="search"
                onChange={(event) => setRegija(event.target.value)}
              />
            </TableCell>
            <TableCell align="center">
              <TextField
                id="outlined-search"
                label="Išči pošto"
                type="search"
                onChange={(event) => setPosta(event.target.value)}
              />
            </TableCell>
            <TableCell align="left">
              {
                <Button
                  variant="contained"
                  onClick={() =>
                    navigate(`/lokacije/${naslov}/${regija}/${posta}`)
                  }
                >
                  Išči
                </Button>
              }
            </TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </TableContainer>
  );
}
