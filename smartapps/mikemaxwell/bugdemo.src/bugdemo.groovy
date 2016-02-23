definition(
    name: "bugDemo",
    singleInstance: true,
    namespace: "MikeMaxwell",
    author: "Mike Maxwell",
    description: "device selection bug demo",
    category: "My Apps",
  	iconUrl: "https://s3.amazonaws.com/smartapp-icons/ModeMagic/Cat-ModeMagic.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/ModeMagic/Cat-ModeMagic@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/ModeMagic/Cat-ModeMagic@3x.png"
)

preferences {
    page(name: "main")
}

def main(){
	dynamicPage(name: "main", title: "main", uninstall: true, install: true) {
        section(){
        	input(
				name			: "baseDevice"
				,title			: "Base Device Type"
				,multiple		: false
				,required		: false
				,type			: "enum"
                ,options		: ["capability.actuator","device.dimmerSwitch","device.keenHomeSmartVent","device.harmonyActivity","device.simulatedMotionSensor"]
				,submitOnChange	: true
             )   
        	 input(
            	name			: "device"
                ,title			: "select a device"
                ,multiple		: false
                ,required		: false
                ,type			: settings.baseDevice
                ,submitOnChange	: true
            )	
            if (settings.device){
            	paragraph(spinOmatic())
            }
        }
    }

}

def spinOmatic(){
	def data = []
		settings.device.properties.each{ p ->
        	data = data.push("${p}\n")
        }
	return data.tostring()
}

def installed() {
    initialize()
}

def updated() {
    unsubscribe()
    initialize()
}

def initialize() {
	
}


