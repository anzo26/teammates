import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Button from "@mui/material/Button";

export default function Navbar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <Button color="inherit" href="/uporabniki">
            Uporabniki
          </Button>
          <Button color="inherit" href="/lokacije">
            Lokacije
          </Button>
          <Button color="inherit" href="/termini">
            Termini
          </Button>
          <Button color="inherit" href="/aktivnosti">
            Aktivnosti
          </Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
