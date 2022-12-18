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


const odstraniUporabnika = (id) => {
  console.log(id);
  api.delete(`/uporabniki/${id}`);
  window.location.reload();
};

export default function FiltriraniUporabniki() {
  let { Pime, Ppriimek, PuporabniskoIme } = useParams();
  const [uporabniki, setUporabniki] = useState([]);
  let navigate = useNavigate();

  useEffect(() => {
    api.get(`/uporabniki/${Pime}/${Ppriimek}/${PuporabniskoIme}`).then((result) => {
      setUporabniki(result.data);
    });
  }, []);

  return (
    <>
      <h1>Uporabniki</h1>
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
          </TableBody>
        </Table>
      </TableContainer>
      <div>
        <Button
          variant="contained"
          style={{ margin: "1rem" }}
          onClick={() => navigate("/uporabniki")}
        >
          Nazaj
        </Button>
      </div>
    </>
  );
}
