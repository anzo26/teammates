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
import React from "react";

const odstraniAktivnost = (id) => {
  console.log(id);
  api.delete(`/aktivnosti/${id}`);
  window.location.reload();
};

export default function AktivnostiTable({ aktivnosti }) {
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
              <strong>Naziv</strong>
            </TableCell>
            <TableCell align="center">
              <strong>Opis</strong>
            </TableCell>
            <TableCell align="center"></TableCell>
            <TableCell align="center"></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {aktivnosti.map((aktivnost) => (
            <TableRow
              key={aktivnost.id}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {aktivnost.id}
              </TableCell>
              <TableCell align="center">{aktivnost.naziv}</TableCell>
              <TableCell align="center">{aktivnost.opis}</TableCell>
              <TableCell align="left">
                {
                  <Button
                    variant="contained"
                    onClick={() => navigate(`/aktivnosti/${aktivnost.id}`)}
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
                    onClick={() => odstraniAktivnost(aktivnost.id)}
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
  );
}