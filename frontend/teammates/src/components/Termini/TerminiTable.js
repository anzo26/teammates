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
import React, { useState } from "react";

const odstraniTermin = (id) => {
  console.log(id);
  api.delete(`/termini/${id}`);
  window.location.reload();
};

export default function TerminiTable({ termini }) {
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
              <strong>Opis</strong>
            </TableCell>
            <TableCell align="center">
              <strong>Začetek</strong>
            </TableCell>
            <TableCell align="center">
              <strong>Število mest</strong>
            </TableCell>
            <TableCell align="center"></TableCell>
            <TableCell align="center"></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {termini.map((termin) => (
            <TableRow
              key={termin.id}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {termin.id}
              </TableCell>
              <TableCell align="center">{termin.opis}</TableCell>
              <TableCell align="center">{termin.zacetek}</TableCell>
              <TableCell align="center">{termin.stevilo_mest}</TableCell>
              <TableCell align="left">
                {
                  <Button
                    variant="contained"
                    onClick={() => navigate(`/termini/${termin.id}`)}
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
                    onClick={() => odstraniTermin(termin.id)}
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