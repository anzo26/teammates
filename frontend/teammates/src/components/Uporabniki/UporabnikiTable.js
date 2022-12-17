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

const odstraniUporabnika = (id) => {
  console.log(id);
  api.delete(`/uporabniki/${id}`);
  window.location.reload();
};

export default function UporabnikiTable({ uporabniki }) {
  const [ime, setIme] = useState("");
  const [priimek, setPriimek] = useState("");
  const [uporabnisko_ime, setUporabnisko_ime] = useState("");
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
              <strong>Ime</strong>
            </TableCell>
            <TableCell align="center">
              <strong>Priimek</strong>
            </TableCell>
            <TableCell align="center">
              <strong>E-mail</strong>
            </TableCell>
            <TableCell align="center">
              <strong>Uporabniško ime</strong>
            </TableCell>
            <TableCell align="center"></TableCell>
            <TableCell align="center"></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {uporabniki.map((uporabnik) => (
            <TableRow
              key={uporabnik.id}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {uporabnik.id}
              </TableCell>
              <TableCell align="center">{uporabnik.ime}</TableCell>
              <TableCell align="center">{uporabnik.priimek}</TableCell>
              <TableCell align="center">{uporabnik.email}</TableCell>
              <TableCell align="center">{uporabnik.uporabnisko_ime}</TableCell>
              <TableCell align="left">
                {
                  <Button
                    variant="contained"
                    onClick={() => navigate(`/uporabniki/${uporabnik.id}`)}
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
                    onClick={() => odstraniUporabnika(uporabnik.id)}
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
                label="Išči Ime"
                type="search"
                onChange={(event) => setIme(event.target.value)}
              />
            </TableCell>
            <TableCell align="center">
              <TextField
                id="outlined-search"
                label="Išči priimek"
                type="search"
                onChange={(event) => setPriimek(event.target.value)}
              />
            </TableCell>
            <TableCell></TableCell>
            <TableCell align="center">
              <TextField
                id="outlined-search"
                label="Išči uporabniško ime"
                type="search"
                onChange={(event) => setUporabnisko_ime(event.target.value)}
              />
            </TableCell>
            <TableCell align="left">
              {
                <Button
                  variant="contained"
                  onClick={() =>
                    navigate(`/uporabniki/${ime}/${priimek}/${uporabnisko_ime}`)
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
