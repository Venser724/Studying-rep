from importlib.util import source_hash
import os       # stdlib
import shutil   # stdlib
import usb      # pyusb>=1.2.1
# g: python venv freeze requirements
# python -m pip install -r requirements.txt

def find_source_path(source_path):
    devices = usb.core.find(find_all=True, bDeviceClass = 8)
    print(f'Devices found: ", +, "{len(devices)}')
    return(source_path)
print(source_hash)
#source_path = '' 
#def find_dest_path(dest_path):
  #from usb.core
  #return None

#dest_path_1 = ''

#os.makedirs(os.path.dirname(''), exist_ok=True)
#shutil.copytree(source_path, dest_path_1)
#print('Complete')