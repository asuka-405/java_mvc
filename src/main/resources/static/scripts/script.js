import { animate, barChart } from "/scripts/animate.js"
import hackTextOnPage from "/scripts/hack.js"
import loadParticles from "/scripts/particles.load.js"

hackTextOnPage()
barChart()
loadParticles()

animate(".fade-in", "fade-in--active")
animate(".slide-in", "slide-in--active")
