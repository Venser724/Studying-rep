import os
import shutil
#import usb-lib XZ
source_path = 'C:/Users/Venser/Desktop/Работа/Новое/Фоспренил 50/' #write smth to find path
#print(os.listdir(source_path))
dest_path = 'C:/Users/Venser/Desktop/123/copy_test' #write smth to find path

os.makedirs(os.path.dirname('C:/Users/Venser/Desktop/123/copy_test'), exist_ok=True)
shutil.copytree(source_path, dest_path)
print('Complete')